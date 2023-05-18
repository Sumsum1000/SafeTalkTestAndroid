import { Task } from "../Models/Task.model.mjs";

// create task
export const createTask = async (req, res) => {
  try {
    const task = await Task.create(req.body);
    res.status(200).json({ task });
  } catch (error) {
    res.status(500).json({ msg: error });
  }
};

//get all tasks
export const getAllTasks = async (req, res) => {
  try {
    const tasks = await Task.find({});
    res.status(200).json({ tasks });
  } catch (error) {
    res.status(500).json({ msg: error });
  }
};
// get single task
export const getTask = async (req, res) => {
  try {
    const id = req.params.id;
    const task = Task.findOne({ _id: id });
    await res.status(200).json({ task });
  } catch (error) {
    res.status(500).json({ msg: error });
  }
};
// update atask
//delete task
