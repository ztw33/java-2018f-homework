# 用模板重写葫芦娃

## IFactory的使用
```java
    interface IFactory<T> {
        T createOnes();
    
        T[][] createMatrix(int n);
    }
    
    class BeingsFactory implements IFactory<Being> {
        public Being[][] createMatrix(int n) {
            return new Being[n][n];
        }
    
        public Being createOnes() {
            return new Being();
        }
    }
```
使用Factory生成泛型对象。

对战场的每个位置，葫芦娃队列，妖怪队列都使用模板重构。