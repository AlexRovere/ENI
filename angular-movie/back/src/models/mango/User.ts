import mongoose, { Schema, Document } from 'mongoose';
import { Video } from '../Video';

export interface User extends Document {
  email: string;
  password: string
  pseudo: string;
  phone: string
  videos: Video[]
}

const UserSchema: Schema = new Schema({
  email: { type: String, required: true, unique: true },
  password: { type: String, required: true },
  pseudo: { type: String, required: true },
  phone: { type: String, required: true },
  videos: { type: [{}], required: false, default: [] }
}, {
  timestamps: true
});

export default mongoose.model<User>('Users', UserSchema);