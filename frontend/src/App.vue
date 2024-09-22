<template>
  <AppNavbar />
  <router-view
    v-if="categories && products"
    :categories="categories"
    :products="products"
    @fetchData="fetchData"
  />
</template>

<script>
import axios from "axios";
import AppNavbar from "./components/AppNavbar.vue";

export default {
  components: {
    AppNavbar,
  },
  data() {
    return {
      products: [],
      categories: [],
    };
  },
  methods: {
    async fetchData() {
      // Get all categories
      await axios
        .get(`${process.env.VUE_APP_API_URL}/category/list`)
        .then((res) => (this.categories = res.data))
        .catch((err) => console.log(err));

      // Get all products
      await axios
        .get(`${process.env.VUE_APP_API_URL}/product`)
        .then((res) => (this.products = res.data))
        .catch((err) => console.log(err));
    },
  },
  mounted() {
    this.fetchData();
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
