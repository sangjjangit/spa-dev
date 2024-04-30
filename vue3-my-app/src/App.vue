<template>
  <h1>{{ message }}</h1>
  <div>
    <ul>
      <!-- 8. 템플릿 -->
      <!--
        - v-bind 속성
        아이디, 클래스, 스타일 등의 HTML 속성 값에 뷰 데이터 값을 연결
        - {{  }} 문법
        뷰 인스턴스의 데이터를 HTML 태그에 연결하여 텍스트 삽입
      -->
      <li v-for="item in items" v-bind:key="item.name">
        {{ item.name }}: {{ item.price }} x {{ item.quantity }} = {{ item.price * item.quantity }} 원
      </li>
    </ul>
    <p>합계(computed): {{ totalPrice }}</p>
    <p>합계(methods): {{ totalPrice2() }}</p>

    <div>
      <!-- 가격: <input type="text" v-on:input="price = $event.target.value" v-bind:value="price" /> -->
      가격: <input type="text" v-on:input="changePrice" v-bind:value="price" />
    </div>

    <div>
      <!--
        12. 디렉티브
        v-if : 참,거짓 여부 html 태그 자체를 표시하지 않는다.
        v-for: 반복
        v-show: 진위 여부에 따라 화면 표시/미표시 display:none; 이다.
        v-bind: vue 데이터 속성 연결
        v-on: 이벤트를 감지 처리
        v-model: 뷰 인스턴스 데이터와 즉시 동기화 input, select, textarea 태그에만 사용 가능. 양방향 데이터 바인딩
      -->
      <form v-on:submit.prevent="onSubmit">
        a: <input type="text" v-mode="a" />
        b: <input type="checkbox" v-mode="b" />
        c: 
        <select v-model="c" multiple>
          <option>Volvo</option>
          <option>Saab</option>
          <option>Opel</option>
        </select>
        d: 
        <input type="checkbox" v-mode="d" value="Music" />Music
        <input type="checkbox" v-mode="d" value="Movie" />Movie
        <input type="checkbox" v-mode="d" value="Sports" />Sports

        <button type="submit">등록</button>

      </form>
    </div>
  </div>
  <br/>
  <br/>
  <br/>
  <div>
    <HelloWorld></HelloWorld>
  </div>
  <div>
    <AllItem></AllItem>
  </div>
  <div>
    <all-item></all-item>
  </div>
  <div>
    <!--
      16. props 속성
      하위 컴포넌트에서 정의한 props 속성을 넣는다.(v-bind:items의 items)
      data 속성의 items 값을 하위 컴포넌트에 전달한다.
    -->
    <item-list v-bind:items="items"></item-list>
  </div>
  <div>
    <ItemList v-bind:items="items"></ItemList>
  </div>

  <div>
    <p>userId : {{userId}} <br/> userPw : {{userPw}}</p>
    <p>member.userId : {{member.userId}} <br/> member.userPw : {{member.userPw}}</p>

    <form @submit.prevent="onUserSubmit">
      userId : <input type="text" v-model="userId" />
      <br/> 
      userPw : <input type="text" v-model="userPw" />
      <br/> 
      member.userId : <input type="text" v-model="member.userId" />
      <br/> 
      member.userPw : <input type="text" v-model="member.userPw" />
      <br/> 
      <button type="submit">등록</button>
      <button @click="onUserReset">초기화</button>
    </form>
  </div>

</template>

<script>
import { computed, onBeforeMount, onBeforeUpdate, onMounted, onUpdated, ref, watch, provide, readonly, reactive } from 'vue';
import ItemList from './components/ItemList.vue'

export default {
  components: {
    ItemList
  },

  // 5. 인스턴스 옵션
  // 컴포지션 setup 함수
  setup() {
    // const message = "Hello Vue!"

    // 6. 인스턴스 라이프 사이클
    // 인스턴스가 마운트되기 전 단계
    onBeforeMount(() => {})
    // 인스턴스가 마운트된 후 단계
    onMounted(() => {})
    // 데이터가 변경되어 DOM에 적용되기 전 단계
    onBeforeUpdate(() => {})
    // 데이터가 변경되어 DOM에 적용된 후 단계
    onUpdated(() => {})

    // 7. data 속성
    const message = ref("Hello Vue!")

    const items = ref([
      { name: 'CPU', price: 432199, quantity: 1},
      { name: '메인보드', price: 4939032, quantity: 1},
      { name: '메모리', price: 99999, quantity: 2},
    ])

    // 9. computed 속성
    const totalPrice = computed(() => {
      return items.value.reduce((sum, item) => {
        return sum + (item.price * item.quantity)
      }, 0)
    }) // 함수결과값 + 0
    // Array.reduce 
    // 함수를 싱행하여 단일 값을 생성(축소)한다.
    // 왼쪽에서 오른쪽으로 작동. 원래 배열은 줄이지 않는다.
    // Array.reduce(function (total, value, index, array)
    // function (초기값/이전에 반환된 값,항목값,항목인덱스,배열자체)

    // 10. methods 속성
    const totalPrice2 = () => {
      return items.value.reduce((sum, item) => {
        return sum + (item.price * item.quantity)
      }, 0)
    }

    // 11. watch 속성
    const price = ref(199999)
    watch(
      price,
      (cur, prev) => {
        console.log('변경된 값:', cur)
        console.log('변경되기 전의 값:', prev)
      },
      {
        immediate: true,
      }
    )

    // 13. 이벤트 처리
    // 14. 폼바인딩
    const a = ref("")
    const b = ref(false)
    const c = ref([])
    const d = ref([])
    const onSubmit = () => {
      console.log("a:", a)
      console.log("b:", b)
      console.log("c:", c)
    }

    // 15. Vue 컴포넌트
    // 지역 컴포넌트, 전역 컴포넌트로 구분
    // 컴포넌트 트리
    // 컴포넌트 명명 규칙: 케밥 케이스(xx-yy-zz), 파스칼 케이스(XxYyZz)
    // 이름은 HTML 템플릿에서 그대로 이름을 사용한다. <xx-yy-zz> , <XxYyZz>

    // 17. provide / Inject
    // 공유할 데이터 정의
    provide('sharedItems', items)    
    provide('readOnlyItem', readonly(items))
    // 공유 데이터 접근 -> ItemList.vue

    // 18. 이벤트 전달
    // emits
    // ItemInput.vue -> ItemList.vue

    // 19. 반응형 변수
    const userId = ref('')
    const userPw = ref('')

    // 객체 타입 반응형 변수
    const member = reactive({
      userId,
      userPw,
    })
    
    // 값 출력 / 값 변경
    const onUserSubmit = () => {
      console.log('userId:', userId.value)
      console.log('userPw:', userPw.value)
      console.log('member.userId:', member.userId)
      console.log('member.userPw:', member.userPw)
    }
    const onUserReset = () => {
      userId.value = ''
      userPw.value = ''
      member.userId = ''
      member.userPw = ''
    }

    return {
      message,
      items,
      totalPrice,
      totalPrice2,
      price,
      a, b, c, d, onSubmit,
      userId,
      userPw,
      member,
      onUserSubmit, 
      onUserReset,
    }
  }
}
</script>