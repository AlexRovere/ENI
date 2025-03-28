import {Video} from './video';

export interface User {
  _id?: string,
  email: string,
  password: string,
  pseudo?: string,
  phone?: string,
  videos?: Video[]
}
