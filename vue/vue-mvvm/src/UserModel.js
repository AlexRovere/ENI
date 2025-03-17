
class UserModel {
  constructor () {
    // Simulating a data source
    this.users = [
      { id: 1, name: 'John Doe', email: 'john@example.com' },
      { id: 2, name: 'Jane Smith', email: 'jane@example.com' },
      { id: 3, name: 'Bob Johnson', email: 'bob@example.com' }
    ];
  }

  // Simulate API call to fetch users
  async fetchUsers () {
    // Simulate network delay
    await new Promise(resolve => setTimeout(resolve, 500));

    // Return a copy to avoid direct modification
    return [...this.users];
  }

  // Simulate API call to update a user
  async updateUser (updatedUser) {
    // Validate input
    if (!updatedUser || !updatedUser.id) {
      throw new Error('Invalid user data');
    }

    // Simulate network delay
    await new Promise(resolve => setTimeout(resolve, 500));

    // Find and update the user
    const index = this.users.findIndex(user => user.id === updatedUser.id);

    if (index === -1) {
      throw new Error('User not found');
    }

    // Update the user
    this.users[index] = { ...updatedUser };

    // Return a copy of the updated user
    return { ...this.users[index] };
  }

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
      id: this.users.length > 0 ? Math.max(...this.users.map(u => u.id)) + 1 : 1,
      name: user.name,
      email: user.email
    };

    // Add to our collection
    this.users.push(newUser);

    // Return a copy of the new user
    return { ...newUser };
  }

  // Delete a user
  async deleteUser (userId) {
    // Validate input
    if (!userId) {
      throw new Error('Invalid user ID');
    }

    // Simulate network delay
    await new Promise(resolve => setTimeout(resolve, 500));

    // Find the user index
    const index = this.users.findIndex(user => user.id === userId);

    if (index === -1) {
      throw new Error('User not found');
    }

    // Remove the user
    this.users.splice(index, 1);

    // Return success
    return true;
  }
}