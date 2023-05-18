import express from "express";

export const taskRouter = express.Router();

import {
  createTask,
  getTask,
  getAllTasks,
} from "../Controllers/tasks.controller.mjs";

// Create task
taskRouter.post("/tasks", (req, res) => {
  createTask(req, res);
});

// get all tasks
taskRouter.get("/tasks", (req, res) => {
  getAllTasks(req, res);
});

// get single task
taskRouter.get("/:id", (req, res) => {
  getTask(req, res);
});

// Edit task
// Delete task
