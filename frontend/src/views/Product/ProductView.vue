<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Our Products</h4>
        <!-- <router-link :to="{ name: 'AddProduct' }" style="float: right">
          <button class="btn">Add Product</button>
        </router-link> -->
      </div>
    </div>
    <div class="row">
      <!--            display all the products in productbox component-->
      <div
        v-for="product of products"
        :key="product.id"
        class="col-md-6 col-xl-4 col-12 pt-3 d-flex"
      >
        <ProductCard :product="product" />
      </div>
    </div>
  </div>
</template>

<script>
import ProductCard from "@/components/Product/ProductCard.vue";

export default {
  name: "ProductView",
  components: { ProductCard },
  props: ["products"],
};
</script>

<style></style>
