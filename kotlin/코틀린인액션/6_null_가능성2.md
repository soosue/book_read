### 6.1.2 타입의 의미

타입은 어떤 값들이 가능한지와 그 타입에 대해 수행할 수 있는 연산의 종류를 결정한다.

허나 자바에서는 String 타입의 변수에 String과 null 두 가지 종류의 값이 들어갈 수 있다. 그렇기에 NullPointerException이 종종 발생하게 된다. `@NotNull`, `@Nullable`, `Optional` 등을 이용해서 줄일 수 있지만 완전한 해결책은 아니다.

코틀린에서는 아예 구분을 함으로써 해법을 제공한다. 먼저 널이 될 수 있는 값을 안전하게 다루게 도와주는 특별한 연산자를 살펴보자.

### 6.1.3 안전한 호출 연산자: ?.

사용예시를 살펴보자.

```kotlin
str?.toUpperCase()
```

str이 null이면 null을 반환하고, null이 아니면 toUpperCase()를 호출한 결과를 반환한다.

주의) 반환된 타입도 null이 될 수 있는 타입이다. 즉 String? 타입이 반환된다.

연쇄적으로 호출할 때도 사용 가능하다.

```kotlin
val country = this.company?.address?.country
```

### 6.1.4 엘비스 연산자: ?:

시계방향으로 90도 돌리면 엘비스 프레슬리가 보일 것이다.

사용예시를 살펴보자.

```kotlin
fun nvl(str: String?) = str ?: ""
```

str이 null이면 ""값을 반환한다.

다음처럼 응용할 수도 있다.

코틀린에서는 return이나 throw 등의 연산도 식이므로, 엘비스 연산자 우항에 return, throw 등의 연산을 넣을 수 있다.

```kotlin
val address = person.company?.address ?: throw IllegalArgumentException("No address")
```

정리)

오늘은 코틀린에서 타입의 값이 null이 될 수 있는 경우를 처리하는 방법에 대해서 알아봤다.

메소드 호출 관련해서는 `?.` 연산자
값 할당 관련해서는 `?:` 연산자를 사용하면 널이 될 수 있는 값에 대해 안전하게 다룰 수 있게 된다.
