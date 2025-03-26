export interface Todo {
  title: string,
  description?: string,
  category?: TodoCategory
}

export enum TodoCategory {
  TODO ="todo",
  IN_PROGRESS = "in progress",
  DONE = "done"
}
