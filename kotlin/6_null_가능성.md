# 6. 코틀린 타입 시스템

## 6.1 널 가능성

코틀린에서 널이 될 수 있는 타입과 널을 처리하는 구문의 문법에 대해 알아보도록 하자.

코틀린은 대부분 자바와 같은 일을 하는 코드지만, 더 간결하고 읽기 쉽게 작성해준다.

코틀린을 비롯한 최신 언어에서는 null 문제를 실행 시점에서 컴파일 시점으로 가져온다.

널이 될 수 있는지 여부를 타입 시스템에 추가함으로써 **컴파일러가 여러 가지 오류를 컴파일 시 미리 감지**해서 실행 시점에 발생할 수 있는 예외의 가능성을 줄일 수 있다.


코틀린에서 null이 될 수 있는 값을 어떻게 표기하고, 코틀린이 어떻게 그값을 처리하는지 살펴보자.

### 6.1.1 널이 될 수 있는 타입

자바와 코틀린은 null 처리방식이 다르다. 자바부터 보자.

자바는 모든 객체 타입이 null을 기본값으로 가지며, 당연하게 변수에 null을 할당할 수 있다. 그리고 매개변수로 null을 전달할 수 있다.
```java
class NullTest {
  public String strLen(String str) { // 1. str은 null을 매개변수로 가질 수 있다.
    return str.length(); // 2. str의 값으로 null이 넘어올 수 있고, 그럴 경우 str.length()를 호출할 때 NullPointerException이 발생한다.
  }
}

strLen("str"); // 가능
strLen(null); // 가능
```
NullPointerException이 발생하지 않기 위해서는 str.length() 호출 전에 if문을 이용하여 
```java
public String strLen(String str) {
  if (str == null) return 0;
  
  return str.length();
}
```
와 같이 null체크를 해주어야 한다. 이렇게 자바에서는 null에 대한 처리를 염두에 두고 코드를 작성하여야 한다.


하지만 코틀린은 자바와 다르게 기본적으로 null을 허용하지 않는다.

```kotlin
fun strLen(s: String) = s.length

strLen("str") // 가능
strLen(null) // 컴파일 시 오류 발생
```

오히려 null을 허용해주기 위해선 명시적으로 코드를 작성해야하고 그 키워드가 `?`이다.
```kotlin
fun strLen(s: String?) = s.length

strLen("str") // 가능
strLen(null) // 가능
```

이로써 코틀린에서 코드를 작성할 때는, null을 명시적으로 표시하지 않는한, 원하지 않는 상황에서 NullPointerException이 발생할 것에 대해 걱정하지 않아도 된다.

그리고 실수로 null을 대입한 것을 컴파일 시점에 발생하는 오류를 통해 알 수 있다.

그렇다면 null이 허용된 타입의 값을 null이 허용되지 않은 타입의 값으로 할당하거나, 허용되지 않은 타입의 함수의 파라미터로 넘기게 되면 어떻게 될까?

컴파일 시 오류가 발생한다.
```kotlin
var str1: String? = null

var str2: String = str1 // Error: Type mismatch: inferred type is String? but String was expected
strLen(str1) // Error: Type mismatch: inferred type is String? but String was expected

fun strLen(s: String) = s.length
```
이로써 좀 더 편리하면서 안전하게 코드를 작성할 수 있게 된다.


하지만 가능한 경우가 있는데 null 검사를 if문으로 해주는 것이다.

```kotlin
var str: String? = null
if (str != null) strLen(str) else 0 // 그냥 strLen(str)만 있었다면 컴파일 시 오류가 발생한다. if를 체크해주면 컴파일 시 오류가 발생하지 않는다.


fun strLen(s: String) = s.length
```

여기까지가 코틀린 null에 관한 기본이었다. null을 다루는데 도움이 되는 여러 도구를 제공한다. 차차 알아보도록 하자.
