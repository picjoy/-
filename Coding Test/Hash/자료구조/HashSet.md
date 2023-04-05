## 📚 HashSet
> HashSet은 Set 인터페이스를 구현한 클래스 \
> HashSet은 **중복된 값을 허용하지 않으며 List 등과는 다르게 입력한 순서가 보장되지 않습니다**

### Set 인터페이스를 구현한 주요 클래스는 3개가 있습니다.
<table>
 <tr align="center">
   <td> 클래스 </td> <td> 특징</td>
   </tr>
 <tr>
   <td> HashSet </td> <td> 순서가 필요없는 데이터를 hash table에 저장 / Set 중에 가장 성능이 좋음 </td>
  </tr>
  <tr >
    <td> TreeSet </td> <td> 저장된 데이터의 값에 따라 정렬 / red-black tree 타입으로 값이 저장 / <br/> HashSet보다 성능이 느림</td>
  </tr>
  <tr >
    <td> LinkedHashSet </td> <td> 연결된 목록 타입으로 구현된 hash table에 데이터 저장 / 저장된 순서에 따라 값이 정렬 /<br/> 셋 중 가장 느림</td>
  </tr>
</table>
3개의 클래스가 성능 차이가 나는 이유는 데이터 정렬 때문입니다.<br/>
HashSet은 별도의 정렬 작업이 없어 제일 빠릅니다.<br/>
하지만 수백만 건의 데이터를 처리하는게 아니면 크게 체감하기는 힘들다고 합니다.

### 🐱‍ HashSet의 특징
* **중복된 값을 허용하지 않음**
* 입력한 순서가 보장되지 않음
* null을 값으로 허용

### 🐱‍🐉 HashSet 사용하기
**1. 자바에서 HashSet을 사용하려면 먼저 import문을 넣어야 합니다.**
```java
import java.util.HashSet;
```
**2. HashSet을 생성하는 방법은 다음과 같습니다.**
```java
// 타입 지정
HashSet<String> colors1 = new HashSet<String>(); 

// 타입 생략 가능 => 기본적으로 빈 HashSet을 생성할 때는 주로 사용
HashSet<String> colors2 = new HashSet<>(); 

// 초기 용량(Capacity) 설정
HashSet<String> colors3 = new HashSet<>(10); 

// 다른 Collection값으로 초기화
HashSet<String> colors4 = new HashSet<>(colors1); 

// Arrays.asList()
HashSet<String> colors5 = new HashSet<>(Arrays.asList("Blue", "Black", "White")); 

//원하는 값들을 추가하면서 생성
HashSet<String> colors6 = new HashSet<>(){{
    add("Blue");
    add("Black");
    add("White");
}};
```
상황에 맞는 방법을 사용해서 HashSet을 생성하면 됩니다.

**3. HashSet 엘레멘트 추가** <br/>
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Black");
        colors.add("White");
        colors.add("Green");
        colors.add("Red");

        System.out.println(colors);
    }
}
```
HashSet은 입력된 순서가 보장되지 않기 때문에 특정 위치에 값을 추가하거나 할 수는 없습니다.

**결과** <br/>
![image](https://user-images.githubusercontent.com/108355379/229990341-58e0fe9e-7259-46b3-bfaf-290851f94313.png)

출력된 값의 순서를 보면 입력한 순서와 상관없이 출력되는 것을 알 수 있습니다.

다른 컬렉션의 값들을 한 번에 입력할 때는 addAll()을 사용합니다.

```java
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Black");
        colors.add("White");
        colors.add("Green");

        HashSet<String> otherColors = new HashSet<>(Arrays.asList("Black", "Yellow", "Purple"));
        colors.addAll(otherColors);

        System.out.println(colors);
    }
}
```
**결과** <br/>
![image](https://user-images.githubusercontent.com/108355379/229990850-7f78d41f-64c7-413f-81da-9faed3cc628e.png)

Black이 중복되지만 한 번만 표시되는 것을 확인할 수 있습니다.

**4.HashSet 엘레멘트 삭제**<br/><br/>
HashSet에 추가된 값을 삭제할 때는 remove(), removeAll(), removeIf()를 호출하면 됩니다.
```java
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Black");
        colors.add("White");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red");
        colors.add("Purple");
        
        // remove() :::: 특정 값을 삭제할 때
        colors.remove("Red");
        System.out.println(colors); // [White, Blue, Purple, Black, Green]
        
        // removeIf() ::: 조건을 적용해서 여러 값들을 삭제할 때
        // .startsWith >> 예제의 코드는 B로 시작하는 색들을 지우는 코드
        colors.removeIf(color -> color.startsWith("B"));
        System.out.println(colors); // [White, Purple, Green]
        
        // removeAll() ::: 다른 컬렉션에 있는 값들을 입력 값으로 받아서 해당 값들을 전부 찾아서 지웁니다.
        colors.removeAll(Arrays.asList("White", "Green"));
        System.out.println(colors); // [Purple]
        
        // clear() ::: HashSet 안의 모든 값을 삭제할 때
        colors.clear();
        System.out.println(colors); // []
    }
}

```

remove()는 값이 지워지면 true를 리턴하기 때문에 삭제와 동시에 값이 존재했었는지 여부를 알 수 있습니다.

**5.HashSet 전체 값 확인** <br/><br/>
HashSet의 전체 값을 확인하는 방법은 잘 사용되는 방법은 아닙니다.

HashSet을 사용하는 이유는 컬렉션 내에 찾고자 하는 값이 존재하는지 여부를 확인하기 위해서입니다.
```java
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Black");
        colors.add("White");
        colors.add("Green");
        colors.add("Red");

        // for-each loop
        for (String color : colors) {
            System.out.print(color + "  ");
        }
        System.out.println();

        // using iterator
        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println();
    }
}
```
for를 사용하는 방법과 iterator를 사용하는 방법을 고려해 볼 수 있습니다.

**6.값 존재 유무 확인**<br/><br/>
HashSet은 컬렉션 내에 값이 존재하는지 여부를 확인하는데 최적화된 자료 구조입니다.

contains() 메소드를 호출해서 값이 존재하는지 여부를 빠르게 확인할 수 있습니다.
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        colors.add("Black");
        colors.add("White");
        colors.add("Green");
        colors.add("Red");

        System.out.println(colors.contains("Green")); // true
        System.out.println(colors.contains("Purple")); // false
    }
}
```
값이 존재하는 경우 true를 리턴하며 없는 경우 false를 리턴합니다.

값이 존재하는지 유무를 파악하는 것이 중요하다면 HashSet을 적극 활용하면 됩니다.
