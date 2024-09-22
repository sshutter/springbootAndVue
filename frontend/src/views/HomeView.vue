<template>
  <div id="home">
    <div id="background-div" class="page-holder bg-cover">
      <div class="container" id="top-section">
        <h3 class="mb-4 rounded text-white" id="heading">
          <a href="#start-shopping" class="disable-link">Start shopping</a>
        </h3>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            <h2 class="pt-3 text-white">Our Products</h2>
          </div>
        </div>
        <div class="row pb-4">
          <div
            v-for="product in products"
            :key="product.id"
            class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
          >
            <ProductCard :product="product" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ProductCard from "@/components/Product/ProductCard.vue";

// @ is an alias to /src

export default {
  name: "HomeView",
  components: { ProductCard },
  props: ["products"],
  data() {
    return {
      prodcuts_size: 0,
    };
  },
  mounted() {
    this.prodcuts_size = Math.min(6, this.products.length);
  },
};
</script>

<style>
.page-holder {
  min-height: 100vh;
  min-width: 100vw;
}

#top-section {
  position: relative;
  min-height: inherit;
  min-width: inherit;
}

.bg-cover {
  background-size: cover !important;
}

#heading {
  position: absolute;
  top: 30%;
  left: 5%;
  font-weight: bold;
  font-size: 40px;
}

#background-div {
  background: rgba(0, 0, 0, 0.6) url("../assets/home.jpg");
  background-blend-mode: darken;
}

.disable-link {
  color: white;
  text-decoration: none;
  transition: color 0.3s ease, font-size 0.3s ease, transform 0.3s ease;
}

.disable-link:hover {
  text-decoration: none;
  color: grey;
  font-size: larger;
  transform: scale(1.05);
}
</style>
