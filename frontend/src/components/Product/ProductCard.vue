<template>
  <div class="card h-100 w-100">
    <div class="embed-responsive embed-responsive-16by9">
      <img
        class="card-img-top embed-responsive-item"
        :src="product.imageUrl"
        :alt="product.name"
      />
    </div>
    <div class="card-body">
      <h5 class="card-title">{{ product.name }}</h5>
      <p class="card-text">
        {{
          product.description.length > 65
            ? product.description.substring(0, 65) + "..."
            : product.description
        }}
      </p>
      <router-link :to="{ name: 'EditProduct', params: { id: product.id } }">
        <button class="btn btn-primary">Edit</button>
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  name: "ProductBox",
  props: ["product"],
};
</script>
<style scoped>
.card-img-top {
  object-fit: cover;
}
</style>
