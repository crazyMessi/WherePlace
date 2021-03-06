[TOC]



# “逛哪儿”接口文档

| 修订版本号 | 修订日期  | 修订人 | 修改内容                           |
| ---------- | --------- | ------ | ---------------------------------- |
| 1.1        | 2020.7.9  | 李卓栋 |                                    |
| 1.2        | 2020.7.10 | 李卓栋 | 修改：三.2.5.1<br />增加：三.2.5.3 |
| 1.3        | 2020.7.10 | 李卓栋 | 主要修改：二.4 、二.1              |

## 一、基本配置

- 测试使用的`ServerURL`:`http://.../wherePlace（暂时未确定）

- 前端向服务器发送的数据的`Content-Type`为`application/x-www-form-urlencoded`;如包含图片，发送的数据的`Content-Type`为`multipart/form-data`

- 所有服务器返回数据均为`json`（即服务器返回数据的Content-Type为`application/json`），统一格式如下：

  ```json
  {
      "code": 0,
      "message": "success!!",
      "data": ...
  }
  ```

- 若本次请求正常，则返回`code`为0，`msg`为“success”；小于0代表错误, 大于0代表非错误性提示。**任何请求都会返回code和message**，下方接口数据中的**传出参数为data中的讯息**，某些接口没有data数据

- 登录时后端会返回token，之后的操作需要使用token，前端将token放于请求头"**Token**"进行请求,下一次无需重复登录

  示例：

  ```json
  {
      "Token": "bdsnf37r43592hb"
  }
  ```

- **统一的错误码**

| 错误码 | 信息                   |
| ------ | ---------------------- |
| 0      | success！！            |
| -1     | 服务器错误             |
| 601    | 登录已过期，请重新登录 |
| 602    | 请求字段不能为空       |

## 二、实例

## *id范围

| storeId | 1001-10000000      |
| ------- | ------------------ |
| userId  | 10000001-100000000 |
| goodId  | 10000001-100000000 |
|         |                    |







### 1.商家内容

| 类型     | 变量名       | 备注                                                         |
| -------- | ------------ | ------------------------------------------------------------ |
| long     | storeId      | 商家唯一Id                                                   |
| long     | userId       | 店主id                                                       |
| double   | longitude    | 经度                                                         |
| double   | latitude     | 纬度                                                         |
| String   | provinces    | 省                                                           |
| String   | city         | 市                                                           |
| String   | block        | 街区                                                         |
| String   | street       | 街道                                                         |
| String   | streetNumber | 街道门牌号                                                   |
| boolean  | ifOpen       | 是否开张 <br />1表示开张 <br />-1表示歇业<br />0表示已注销<br /> |
| String   | storeName    | 商店名                                                       |
| String   | storeDesc    | 商店描述                                                     |
| String   | storePhoto   | 商店图片                                                     |
| Object[] | goodList     | 商品列表                                                     |
| int      | followers    | 关注数                                                       |
| int      | volumes      | 成交数                                                       |
|          |              |                                                              |
|          |              |                                                              |



### 2.商品对象

| 类型   | 变量名    | 备注       |
| ------ | --------- | ---------- |
| long   | goodId    | 商品id     |
| long   | storeId   | 所属商店id |
| String | goodName  | 商品名称   |
| float  | price     | 商品价格   |
| String | goodDesc  | 商品描述   |
| String | goodPhote | 商品图片   |
| int    | favorites | 收藏数     |
| int    | sales     | 销量       |

### 3.用户对象

| 类型   | 变量名   | 备注                                                |
| ------ | -------- | --------------------------------------------------- |
| String | userName | 用户名                                              |
| long   | userId   | 用户Id                                              |
| String | psw      | 密码                                                |
| int    | userType | 用户类型（商户/普通用户），1表示商户，2表示普通用户 |

### 

### 4.评论对象

| 类型   | 变量名    | 备注           |
| ------ | --------- | -------------- |
| long   | commentId | 评论id         |
| long   | userId    | 评论者的id     |
| long   | timestamp | 评论时间       |
| String | content   | 评论内容       |
| long   | goodId    | 评论的商品的id |



### 5、摊库

| 类型           | 变量名 | 备注   |
| -------------- | ------ | ------ |
| long           | userId | 用户Id |
| faoverListName | String | 摊库名 |



## 三、接口

### 1、账号的注册和登录，店主认证

#### 1.1注册

| URL       | method |
| --------- | ------ |
| /register | POST   |

| 传入参数 | 类型   | 是否可为空 | 说明 |
| -------- | ------ | ---------- | ---- |
| userName | String | 否         |      |
| password | String | 否         |      |

| 错误码 | 信息         |
| ------ | ------------ |
| 1      | 用户名已注册 |

| 传出参数 | 类型 | 说明                 |
| -------- | ---- | -------------------- |
| userId   | long | 用户id，需要用户牢记 |

#### 1.2登录

| URL    | method |
| ------ | ------ |
| /login | POST   |

| 传入参数 | 类型   | 是否可为空 | 说明     |
| -------- | ------ | ---------- | -------- |
| userId   | long   | 否         | 用户账号 |
| password | String | 否         | 密码     |

| 错误码 | 信息           |
| ------ | -------------- |
| 1      | 账号或密码错误 |

| 传出参数 | 类型   | 说明  |
| -------- | ------ | ----- |
| token    | String | token |

### 1.3店主认证



### 2、商店的创建、开张、歇业、收藏；查看商店



#### 2.1商店的创建

| URL       | method |
| --------- | ------ |
| /setStore | POST   |

| 传入参数   | 类型         | 是否可为空 | 说明                  |
| ---------- | ------------ | ---------- | --------------------- |
| storeName  | String       | 否         | 商店名                |
| storeDesc  | Stirng       | 是         | 商店描述              |
| storePhoto | file         | 是         | 需要放在requestbody中 |
| double     | longitude    | 是         | 经度                  |
| double     | latitude     | 是         | 纬度                  |
| String     | provinces    | 否         | 省                    |
| String     | city         | 否         | 城市                  |
| String     | block        | 是         | 街区                  |
| String     | street       | 是         | 街道                  |
| String     | streetNumber | 是         | 街区门牌号            |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数 | 类型 | 说明   |
| -------- | ---- | ------ |
| shopId   | long | 商店id |

#### 2.2商店的开张、歇业

| URL          | method |
| ------------ | ------ |
| /changeState | POST   |



| 传入参数 | 类型         | 是否可为空 | 说明       |
| -------- | ------------ | ---------- | ---------- |
| storeId  | long         | 否         | 商店id     |
| double   | longitude    | 是         | 经度       |
| double   | latitude     | 是         | 纬度       |
| String   | city         | 是         | 城市       |
| String   | block        | 是         | 街区       |
| String   | street       | 是         | 街道       |
| String   | streetNumber | 是         | 街区门牌号 |

| 错误码 | 信息               |
| ------ | ------------------ |
| 1      | 商店与店主不匹配   |
| 1      | 商店不存在或已删除 |
|        |                    |

| 传出参数 | 类型 | 说明                                |
| -------- | ---- | ----------------------------------- |
| ifOpen   | int  | 表示是否开张。1表示开张，-1表示歇业 |

#### 2.4商店的收藏

##### 2.4.1 获取摊库列表

| URL           | method |
| ------------- | ------ |
| /getFavorList | POST   |

| 错误码 | 信息 |
| ------ | ---- |
| 1      |      |

| 传出参数  | 类型       | 说明                                         |
| --------- | ---------- | -------------------------------------------- |
| favorList | String【】 | 已创建的摊库列表（用户最初有一个“默认摊库”） |

##### 2.4.2 创建摊库

| URL             | method |
| --------------- | ------ |
| /creatFavorList | POST   |

| 传入参数      | 类型   | 是否可为空 | 说明   |
| ------------- | ------ | ---------- | ------ |
| favorListName | String | 否         | 摊库名 |
|               |        |            |        |

| 错误码 | 信息           |
| ------ | -------------- |
| 1      | 同名摊库已存在 |

##### 2.4.3 放入已有摊库

| URL         | method |
| ----------- | ------ |
| /favorStore | POST   |

| 传入参数      | 类型   | 是否可为空 | 说明               |
| ------------- | ------ | ---------- | ------------------ |
| storeId       | long   | 否         | 商店id             |
| favorListName | String | 是         | 默认放入“默认摊库” |

| 错误码 | 信息       |
| ------ | ---------- |
| 1      | 摊库不存在 |

#### 2.5、商店的分类

| URL                  | method |
| -------------------- | ------ |
| /storeClassification | POST   |

| 传入参数 | 类型   | 是否可为空 | 说明                                     |
| -------- | ------ | ---------- | ---------------------------------------- |
| typeName | String | 否         | 在已给的类型<br />中选择或自己<br />创建 |
| storeId  | long   | 否         | 商店id                                   |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数 | 类型 | 说明 |
| -------- | ---- | ---- |
|          |      |      |

#### 2.6查看商店

##### 2.6.1用户查看所有商店（条件查询）

| URL        | method |
| ---------- | ------ |
| /viewStore | POST   |

| 传入参数                      | 类型   | 是否可为空 | 说明                               |
| ----------------------------- | ------ | ---------- | ---------------------------------- |
| longitude、latitude           | double | 是         | 列表将按与所给位置距离降序排序     |
| street                        | String | 是         |                                    |
| block                         | String | 是         |                                    |
| longitude、latitude、distance | double | 是         | 获取一定距离内的商店（按距离降序） |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数  | 类型     | 说明     |
| --------- | -------- | -------- |
| storeList | object[] | 商店列表 |

##### 2.6.2用户查看收藏商店

| URL            | method |
| -------------- | ------ |
| /viewFavorList | POST   |

| 传入参数      | 类型   | 是否可为空 | 说明   |
| ------------- | ------ | ---------- | ------ |
| favorListName | String | 否         | 摊库名 |
|               |        |            |        |

| 错误码 | 信息       |
| ------ | ---------- |
| 1      | 摊库不存在 |

| 传出参数  | 类型       | 说明     |
| --------- | ---------- | -------- |
| storeList | Object【】 | 摊库列表 |

##### 2.6.3店主查看自己的商店

##### 

| URL          | method |
| ------------ | ------ |
| /viewMyStore | POST   |

| 传出参数  | 类型       | 说明     |
| --------- | ---------- | -------- |
| storeList | Object【】 | 所有商店 |

##### 



### 3、商品的关注、评论、发布、结算；查看商品

#### 3.1商品的关注

| URL        | method |
| ---------- | ------ |
| /favorGood | POST   |

| 传入参数 | 类型 | 是否可为空 | 说明 |
| -------- | ---- | ---------- | ---- |
| goodId   | long | 否         |      |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数 | 类型 | 说明 |
| -------- | ---- | ---- |
|          |      |      |

#### 3.2商品的评论

| URL          | method |
| ------------ | ------ |
| /commentGood | POST   |

| 传入参数       | 类型   | 是否可为空 | 说明         |
| -------------- | ------ | ---------- | ------------ |
| goodId         | long   | 否         | 评论对象的id |
| commentContent | String | 否         | 评论内容     |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数  | 类型      | 说明 |
| --------- | --------- | ---- |
| timeStamp | timeStamp |      |

#### 3.3商品的发布

| URL         | method |
| ----------- | ------ |
| publishGood | POST   |

| 传入参数  | 类型   | 是否可为空 | 说明                           |
| --------- | ------ | ---------- | ------------------------------ |
| storeId   | long   | 否         | 所属商店id                     |
| goodName  | String | 否         | 商品名称                       |
| price     | double | 否         | 商品价格                       |
| goodDesc  | Stirng | 是         | 商品描述                       |
| goodPhoto | Flie   | 是         | 商品图片 需要放在requestbody中 |
|           |        |            |                                |

| 错误码 | 信息               |
| ------ | ------------------ |
| 1      | 本店已有同名商品   |
| 2      | 店面不存在或已注销 |
|        |                    |

| 传出参数 | 类型 | 说明   |
| -------- | ---- | ------ |
| goodId   | long | 商品id |

#### 3.4商品的结算

| URL          | method |
| ------------ | ------ |
| /accountGood | POST   |

| 传入参数 | 类型 | 是否可为空 | 说明   |
| -------- | ---- | ---------- | ------ |
| goodId   | long | 否         | 商品id |
|          |      |            |        |

| 错误码 | 信息       |
| ------ | ---------- |
| 1      | 商品不存在 |

| 传出参数 | 类型 | 说明 |
| -------- | ---- | ---- |
| sales    | int  | 销量 |

#### 3.5商品的查看

| URL        | method |
| ---------- | ------ |
| /viewGoods | POST   |

| 传入参数  | 类型 | 是否可为空 | 说明                                                       |
| --------- | ---- | ---------- | ---------------------------------------------------------- |
| storeId   | long | 是         | 所查看的商店。若该字段为空，则默认所看该用户关注已的商品， |
| ifPrice   | int  | 是         | 若传入0，则商品列表将按参数降序；若传入1，则为升序         |
| ifContent | int  | 是         | 若传入0，则商品列表将按参数降序；若传入1，则为升序         |
| ifSales   | int  | 是         | 若传入0，则商品列表将按参数降序；若传入1，则为升序         |
| ifFavor   | int  | 是         | 若传入0，则商品列表将按参数降序；若传入1，则为升序         |

| 错误码 | 信息 |
| ------ | ---- |
|        |      |

| 传出参数 | 类型       | 说明     |
| -------- | ---------- | -------- |
| goodList | Object【】 | 商品列表 |