import express from "express";
import mongoose from "mongoose";
import "dotenv/config";
import { taskRouter } from "./Routes/Task.route.mjs";

const PORT = process.env.PORT || 8080;
const mongo_uri = process.env.MONGO_URI;

const app = express();
app.use(express.json());
app.use(express.static("./public"));

app.use("/api/v1/", taskRouter);

// app.get("/", (req, res) => {
//   res.json({ text: "hello from 8080" });
// });

const start = async () => {
  try {
    await mongoose.connect(mongo_uri);
    app.listen(PORT, console.log(`Server running on ${PORT}`));
  } catch (error) {
    console.log(error);
  }
};

start();
