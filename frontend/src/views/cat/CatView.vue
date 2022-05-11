<template>
  <div>
    <div class="row">
      <button class="btn btn-primary">
        <i class="bi bi-plus"></i>
        Add
      </button>
      <button class="btn btn-secondary" @click="get()">
        <i class="bi bi-arrow-clockwise"></i>
        Load
      </button>
    </div>
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Age in years</th>
          <th scope="col">Picture</th>
        </tr>
      </thead>
      <tbody v-if="cats != null">
        <tr v-for="cat in cats" :key="cat.id">
          <th>
            {{ cat.id }}
            <input
              class="form-check-input"
              type="checkbox"
              value=""
              id="flexCheckDefault"
            />
          </th>
          <td>{{ cat.name }}</td>
          <td>{{ cat.ageInYears }}</td>
          <td><img :src="cat.picUrl" /></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

import { ICat } from "./Cat";
import { BASE_URL } from "../../config";

export default defineComponent({
  data() {
    return {
      cats: null as ICat[] | null,
      page: 0,
      pageSize: 20,
    };
  },
  methods: {
    async get() {
      this.cats = null;
      this.cats = await (await fetch(`${BASE_URL}/cats`)).json();
    },
  },
  mounted() {
    this.get();
  },
});
</script>

<style scoped>
img {
  height: 100px;
}
</style>
