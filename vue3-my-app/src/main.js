import { createApp, ref } from 'vue'
import App from './App.vue'
import HelloWorld from './components/HelloWorld.vue'

// 컴포지션 API
const app = createApp(App)
// const app = createApp({})


// 컴포넌트 정의
app.component('AllItem', {
  setup() {
    console.log('xxxxxxxxxxxx:')
    const items1 = ref([
      { name: 'CPU', price: 432199, quantity: 1},
      { name: '메인보드', price: 4939032, quantity: 1},
      { name: '메모리', price: 99999, quantity: 2},
    ])
    return {
      items1,
    }
  },
  template:`
      <ul>
        <li v-for="item in items1" v-bind:key="item.name">
          {{ item.name }}의 가격: <input type="text" v-on:input="item.price = $event.target.value" v-bind:value="item.price">
        </li>
      </ul>
    `,
})

// app.component('', {}) : 이 방식은 아무리해도 화면이 안나온다. 콘솔로그는 찍히는데...
// vue 파일을 만들어서 전역컴포넌트 등록은 잘된다.

// app.component('test-title', {
//   template:`
//     <h1>test</h1>
//     `,
// })
app.component('HelloWorld', HelloWorld)
app.mount('#app')