export const saveTokenFCM = async (req, res) => {
    try {
        const userId = res.locals.userId;
        const token = req.body.token;

        const tokenUser= await checkSameToken(token)
        console.log(tokenUser)

        if (!userId || !token) {
            return sendResponse(res, null, "Invalid data provided", 400, "invalid_data", 400);
        }

        const userData = await findOrUpdateUserTokens(userId, token);
        if (userData) {
            return sendResponse(res, null, "FCM token updated successfully", 200, "token_updated", 200);
        }else {
            throw 500
        }

    } catch (error) {
        console.error("Error saving FCM token:", error);
        return sendResponse(res, null, "Database error", 500, "database_error", 500);
    }
};



export const findOrUpdateUserTokens = async (userId, token) => {
  const database = await getMongoDatabase();

  const userExist = await database.collection(COLLECTION.fcm_token).findOne({ userId: userId });
  if (userExist) {
      const updatedTokens = [...new Set([...userExist.tokens, token])];

      const result = await database.collection(COLLECTION.fcm_token).updateOne(
          { userId: userId },
          { $set: { tokens: updatedTokens } }
      );

      if (result.modifiedCount > 0) {
          return true;
      } else {
          return false;
      }
  } else {
      const obj = {
          userId: userId,
          tokens: [token]
      };

      const saved = await saveToken(obj);
      return saved ? saved : false;
  }
};

export const saveToken = async (obj) => {
  const database = await getMongoDatabase();
  let result = await database.collection(COLLECTION.fcm_token).insertOne(obj)

  if (result.acknowledged) {
    return obj
  }
  else {
    return false
  }
}

export const checkSameToken = async (token)=>{

  console.log(token)
  
  const database = await getMongoDatabase();

  let result = await database.collection(COLLECTION.fcm_token).find({"tokens":token}).project({ userId: 1, _id: 0 }).map(doc => doc.userId).toArray()

  return result
}
