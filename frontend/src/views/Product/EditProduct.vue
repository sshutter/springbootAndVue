<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Product</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form v-if="product">
          <div class="form-group">
            <label>Product Name</label>
            <input
              type="text"
              class="form-control"
              v-model="product.name"
              required
            />
          </div>
          <div class="form-group">
            <label>Description</label>
            <input
              type="text"
              class="form-control"
              v-model="product.description"
              required
            />
          </div>
          <div class="form-group">
            <label>Image URL</label>
            <input
              type="text"
              class="form-control"
              v-model="product.imageUrl"
              required
            />
          </div>
          <div class="form-group">
            <label>Price</label>
            <input
              type="text"
              class="form-control"
              v-model="product.price"
              required
            />
          </div>
          <div class="form-group">
            <label>Category</label>
            <select class="form-control" v-model="product.categoryId" required>
              <option
                v-for="category in categories"
                :key="category.id"
                :value="category.id"
              >
                {{ category.categoryName }}
              </option>
            </select>
          </div>
          <button type="button" class="btn btn-primary" @click="editProduct">
            Submit
          </button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import swal from "sweetalert";
export default {
  data() {
    return {
      product: null,
      id: null,
    };
  },
  props: ["products", "categories"],
  methods: {
    async editProduct() {
      // We have products because, product is many-to-one with category
      await axios
        .put(
          `${process.env.VUE_APP_API_URL}/product/update/${this.id}`,
          this.product
        )
        .then(() => {
          this.$emit("fetchData");
          this.$router.push({ name: "Product" });
          swal({
            text: "product has been updated successfully",
            icon: "success",
          });
        })
        .catch((err) => console.log("err", err));
    },
  },
  mounted() {
    this.id = this.$route.params.id;
    this.product = this.products.find((product) => product.id == this.id);
  },
};
</script>
