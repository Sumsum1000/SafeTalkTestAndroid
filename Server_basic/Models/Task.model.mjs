import mongoose from "mongoose";

const TaskSchema = new mongoose.Schema({
  text: {
    type: String,
    required: [true, "Must provide content"],
    trim: true,
  },
});

export const Task = mongoose.model("Task", TaskSchema);
