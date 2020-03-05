# 
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
|  |  |  |  |

# Administrator
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| administrator_id | int(11) | 主键，自增 | Id |
| username | varchar(50) | 非空，唯一 | 用户名 |
| real_name | varchar(20) |  | 真实姓名 |
| encrtpted_password | varchar(100) | 非空 | MD5密码 |
| status | tinyint | 非空，默认启用 | 状态（0禁用，1启用） |
| create_time | datetime | 非空 | 创建时间 |
| avatar_url | varchar(100) |  | 头像地址 |

# Order
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| order_id | int(11) | 主键，自增 | Id |
| customer_id | varchar(50) | 非空 | 客户id |
| total_price | double(10,2) | 非空 | 总金额 |
| status | tinyint | 非空，默认启用 | 状态（0禁用，1启用） |
| reword_points | varchar(50) |  | 重述 |
| create_time | datetime | 非空 | 创建时间 |
| update_time | datetime | 非空 | 修改时间 |

# Product
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| peoduct_id | int(11) | 主键，自增 | Id |
| peoduct_name | varchar(50) | 非空 | 商品名称 |
| product_code | varchar(50) | 非空 | 商品编码 |
| price | double(10,2) | 非空 | 商品单价 |
| discount | double(10,2) |  | 商品折后价 |
| quantity | int(11) | 非空 | 商品数量 |
| status | tinyint | 非空，默认启用 | 状态（0禁用，1启用 |
| main_pic_url | varchar(100) | 非空 | 商品图片地址 |
| reword_points | varchar(100) |  | 重述 |

# OrderHistory
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| order_history_id | int(11) | 主键，自增 | Id |
| order_id | int(11) | 非空 | 订单id |
| time | datetime | 非空 | 退货时间 |
| order_status | tinyint | 非空，默认启用 | 状态（0禁用，1启用）|
| comment | varchar(100) |  | 描述 |
| customer_notified | tinyint | 非空，默认禁用 | 通知状态（0禁用，1启用） |

# Return
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| return_id | int(11) | 主键，自增 | Id |
| order_id | int(11) | 非空 | 订单id |
| order_time | datetime | 非空 | 订单时间 |
| refunder_name | varchar(50) | 非空 | 退款人 |
| status | tinyint | 非空，默认没有 | 状态（0没有，1有）|
| mobile | varchar(50) | 非空 | 联系电话 |
| return_action | varchar(50) | 非空 | 返回行动 |
| email | varchar(50) | 非空 | 邮箱 |
| product_code | varchar(50) | 非空 | 商品编码 |
| product_name | varchar(50) | 非空 | 商品名称 |
| comment | varchar(100) |  | 描述 |
| quantity | int(11) | 非空 | 商品数量 |
| reason | varchar(100) |  | 退款原因 |
| opened | varchar(100) |  | 打开 |
| create_time | datetime | 非空 | 创建时间 |
| update_time | datetime | 非空 | 修改时间 |

# ReturnHistory
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| return_history_id | int(11) | 主键，自增 | Id |
| return_id | int(11) | 非空 | 订单id |
| time | datetime | 非空 | 时间 |
| order_status | tinyint | 非空，默认启用 | 状态（0禁用，1启用）|
| comment | varchar(100) |  | 描述 |
| customer_notified | tinyint | 非空，默认禁用 | 通知状态（0禁用，1启用）|

# Customer
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| customer_id | int(11) | 主键，自增 | Id |
| real_name | varchar(50) | 非空，唯一 | 用户名 |
| avatar_url | varchar(100) |  | 头像地址 |
| encrtpted_password | varchar(100) | 非空 | MD5密码 |
| mobile | varchar(50) | 非空 | 手机号 |
| mobile_verified | varchar(50) | 非空 | 手机验证码 |
| email | varchar(50) | 非空 | 邮箱号 |
| email_verified | varchar(50) | 非空 | 邮箱验证码 |
| status | tinyint | 非空，默认启用 | 状态（0禁用，1启用）|
| create_time | datetime | 非空 | 创建时间 |
| news_subscrubed | varchar(50) |  | 新建 |
| reword_points | varchar(100) |  | 重述 |
| default_address_id | int(11) |  | 默认地址id |

# Address
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| address_id | int(11) | 主键，自增 | Id |
| customer_id |  int(11) | 非空 | 客户Id |
| receiver_name |  varchar(50) | 非空 | 收货人 |
| content |  varchar(50) | 非空 | 地址 |
| tag |  varchar(50) |  | 标签 |

# ProductDetail
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| product_id | int(11)| 非空 | 商品id|
| description | varchar(250) | | 商品的描述|
| other_pic_urls | varchar(20)| | 商品图片地址|

# OrderDetail
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| order_id | int(11) | | 订单Id |
| pay_method | int(11) | | |
| invoice_address | int(11) | | |
| invoice_price |double(10)| 非空 ||
| ship_method | tinyint | 非空,默认启用 | |
| ship_address | datetime | 非空 ||
| ship_price | double(10) | 非空 | |
| comment | varchar(100)| | |
| content | varchar(100)| | |

# Content
| 字段 | 类型 | 约束 | 说明 |
|---|---|---|---|
| product_id | int(11) | | 订单Id |
| product_code | int(11) | | |
| product_name | varchar(20) | | |
| quantity |int(100)|非空| 数量 |
| unit_price | tinyint | 非空,默认启用 | |
| unit_reword_points | varchar(100)| | |