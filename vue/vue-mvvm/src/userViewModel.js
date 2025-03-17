// userModel.js
import { reactive } from 'vue';

// Initial data
const initialUsers = [
  { id: 1, name: 'John Doe', email: 'john@example.com' },
  { id: 2, name: 'Jane Smith', email: 'jane@example.com' },
  { id: 3, name: 'Bob Johnson', email: 'bob@example.com' }
];

// Create a singleton model instance
const createUserModel = () => {
  // Private state
  const state = reactive({
    users: [...initialUsers]
  });

  // Model methods
  const model = {
    // Fetch all users
    async fetchUsers () {
      // Simulate network delay
      await new Promise(resolve => setTimeout(resolve, 500));

      // Return a copy to avoid direct modification
      return [...state.users];
    },

    // Update a user
    async updateUser (updatedUser) {
      // Validate input
      if (!updatedUser || !updatedUser.id) {
        throw new Error('Invalid user data');
      }

      // Simulate network delay
      await new Promise(resolve => setTimeout(resolve, 500));

      // Find and update the user
      const index = state.users.findIndex(user => user.id === updatedUser.id);

      if (index === -1) {
        throw new Error('User not found');
      }

      // Update the user
      state.users[index] = { ...updatedUser };

      // Return a copy of the updated user
      return { ...state.users[index] };
    },

    // Add a new user
    async addUser (user) {
      // Validate input
      if (!user || !user.name || !user.email) {
        throw new Error('Invalid user data');
      }

      // Simulate network delay
      await new Promise(resolve => setTimeout(resolve, 500));

      // Create a new user with a new ID
      const newUser = {
        id: state.users.length > 0 ? Math.max(...state.users.map(u => u.id)) + 1 : 1,
        name: user.name,
        email: user.email
      };

      // Add to our collection
      state.users.push(newUser);

      // Return a copy of the new user
      return { ...newUser };
    },

    // Delete a user
    async deleteUser (userId) {
      // Validate input
      if (!userId) {
        throw new Error('Invalid user ID');
      }

      // Simulate network delay
      await new Promise(resolve => setTimeout(resolve, 500));

      // Find the user index
      const index = state.users.findIndex(user => user.id === userId);

      if (index === -1) {
        throw new Error('User not found');
      }

      // Remove the user
      state.users.splice(index, 1);

      // Return success
      return true;
    }
  };

  return model;
};

// Singleton instance
let instance = null;

// Export composable function
export function useUserModel () {
  if (!instance) {
    instance = createUserModel();
  }
  return instance;
}
