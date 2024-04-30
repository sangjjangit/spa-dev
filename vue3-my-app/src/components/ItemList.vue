<template>
  <h1>item list</h1>
  <div>
    <ul>
      <li v-for="(item, index) in items" v-bind:key="item.name">
        {{ item.name }}: {{ item.price }} x {{ item.quantity }} = {{ item.price * item.quantity }} 원

        <!-- 이벤트 수신 및 처리 -->
        <ItemInput v-bind:item="item" v-bind:item-index="index" v-on:change-price="handleChangePrice"></ItemInput>
      </li>
    </ul>
    <p>합계: {{ totalPrice }} 원</p>
  </div>
</template>

<script>
  import { computed, inject } from 'vue'
  import ItemInput from './ItemInput.vue'

  export default {
    components: {
      ItemInput
    },
    // props 속성 정의
    props: {
      items: {
        // type: Object,
        default: () => {
          return []
        }}
    },
    setup(props) {

      const totalPrice = computed(() => {
        return props.items.reduce(function (sum, item) {
          return sum + (item.price * item.quantity)
        }, 0)
      })

      // 공유 데이터 접근
      const sharedItems = inject('sharedItems')
      console.log('sharedItems:', sharedItems)
      const readOnlyItem = inject('readOnlyItem')
      console.log('readOnlyItem:', readOnlyItem)

      const changePrice = inject('changePrice')
      console.log('changePrice:', changePrice)

      // change-price 이벤트 처리 메서드
      const handleChangePrice = (newPrice, index) => {
        console.log('handleChangePrice')
        console.log('newPrice:', newPrice)
        console.log('index:', index)
        // changePrice(newPrice, index)
      }

      return {
        totalPrice,
        handleChangePrice,
      }
    },
  }
</script>