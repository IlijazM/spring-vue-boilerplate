import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import CatsView from "@/views/cat/CatView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "cats",
    component: CatsView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
