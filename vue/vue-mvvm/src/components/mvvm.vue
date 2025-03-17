<template>
  <div class="mvvm-example">
    <h1>Vue 3 MVVM Example</h1>

    <div class="user-section">
      <h2>User Information</h2>
      <div v-if="vm.loading">Loading...</div>
      <div v-else>
        <div class="user-card" v-for="user in vm.users" :key="user.id">
          <h3>{{ user.name }}</h3>
          <p>Email: {{ user.email }}</p>
          <button @click="vm.selectUser(user)">Select User</button>
        </div>

        <div class="selected-user" v-if="vm.selectedUser">
          <h3>Selected User: {{ vm.selectedUser.name }}</h3>
          <input
            v-model="vm.userNameInput"
            placeholder="Change user name" />
          <button @click="vm.updateSelectedUser()">Update Name</button>
        </div>
      </div>

      <div class="controls">
        <button @click="vm.loadUsers()">Reload Users</button>
        <button @click="vm.clearSelection()">Clear Selection</button>
      </div>

      <div class="status" v-if="vm.statusMessage">
        {{ vm.statusMessage }}
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { useUserViewModel } from '../userViewModel';

// Create the ViewModel instance
const vm = useUserViewModel();

// Load users when component is mounted
onMounted(() => {
  vm.loadUsers();
});
</script>

<style scoped>
.mvvm-example {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.user-card {
  border: 1px solid #ddd;
  padding: 15px;
  margin-bottom: 10px;
  border-radius: 5px;
}

.selected-user {
  margin-top: 20px;
  padding: 15px;
  background-color: #f5f5f5;
  border-radius: 5px;
}

.controls {
  margin-top: 20px;
}

.status {
  margin-top: 15px;
  padding: 10px;
  background-color: #f0f8ff;
  border-left: 4px solid #1e90ff;
}

input {
  padding: 8px;
  margin-right: 10px;
}

button {
  padding: 8px 12px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

button:hover {
  background-color: #45a049;
}
</style>