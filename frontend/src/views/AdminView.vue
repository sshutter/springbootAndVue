<template>
  <router-link :to="{ name: 'Category' }">
    <button class="btn btn-primary btn-lg my-4">Admin Category</button>
  </router-link>
  <br />
  <router-link :to="{ name: 'Product' }">
    <button class="btn btn-primary btn-lg">Admin Product</button>
  </router-link>
</template>
<script>
export default {};
</script>
<style>
.btn {
  margin-bottom: 20px;
}
</style>
