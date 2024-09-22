import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AddCategory from "@/views/Category/AddCategory.vue";
import CategoryView from "@/views/Category/CategoryView.vue";
import EditCategory from "@/views/Category/EditCategory.vue";
import AdminView from "@/views/AdminView.vue";
import ProductView from "@/views/Product/ProductView.vue";
import EditProduct from "@/views/Product/EditProduct.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/admin/category/add",
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category",
    name: "Category",
    component: CategoryView,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory,
  },
  {
    path: "/admin",
    name: "Admin",
    component: AdminView,
  },
  {
    path: "/admin/product",
    name: "Product",
    component: ProductView,
  },
  {
    path: "/admin/product/:id",
    name: "EditProduct",
    component: EditProduct,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
