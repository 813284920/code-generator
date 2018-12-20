server:
  port: 80
#third:
#  appid: wxbfc804111a0452d5
#  secretKey: 4f1e447349852bfe4dbe71aee5a0a919
spring:
  servlet:
    multipart:
      location: ${location}
  redis:
    cluster:
      nodes: 10.0.0.211:6380,10.0.0.211:6381,10.0.0.212:6380,10.0.0.212:6381
      max-redirects: 3

  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    platform: mysql
    continue-on-error: false # 在初始化数据库时，遇到错误是否继续
    driver-class-name: com.mysql.jdbc.Driver # mysql驱动
    url: jdbc:mysql://10.0.0.210:3306/zzw1?useSSL=false&useUnicode=true&characterEncoding=utf-8 # 基础数据库名,用空就从config 去拉
    username: write  # 数据用户名，需要从config-server中发现
    password: zzw123456 # 数据用密码，需要从config-server中发现
    useUnicode: true # 是否使用Unicode字符集，如果参数characterEncoding设置为gb2312或gbk，本参数值必须设置为true
    characterEncoding: utf8mb4 # 当useUnicode设置为true时，指定字符编码
    autoCommit: true # 指定updates是否自动提交
    autoReconnect: true # 当数据库连接异常中断时，是否自动重新连接
    failOverReadOnly: false # 自动重连成功后，连接是否设置为只读
    maxReconnects: 3 # autoReconnect设置为true时，重试连接的次数
    initialTimeout: 2 # autoReconnect设置为true时，两次重连之间的时间间隔，单位：秒
    zerodatetimebehavior: converttonull
    allowMultiQueries: true # 在一条语句中，允许使用“;”来分隔多条查询
    testWhileIdle: true # 连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除
    test-on-borrow: true #在取出连接时进行有效验证
    validation-query: select user()
    # 连接池
    hikari:
      auto-commit: true # 指定updates是否自动提交
      connection-test-query: select user() # 指定校验连接合法性执行的sql语句
      connection-timeout: 60000 # 指定连接的超时时间，毫秒单位
      idle-timeout: 10000 # 指定连接多久没被使用时，被设置为空闲，默认为10ms
      initialization-fail-fast: true # 当创建连接池时，没法创建指定最小连接数量是否抛异常
      leak-detection-threshold: 60000 # 使用Hikari connection pool时，多少毫秒检测一次连接泄露.
      login-timeout: 10 # 指定连接数据库的超时时间
      maximum-pool-size: 200 # 指定连接池最大的连接数，包括使用中的和空闲的连接.
      minimum-idle: 5 # 指定连接维护的最小空闲连接数
      max-lifetime: 60000  #连接生命时长, 比mysql的wait_timeout短1分钟左右


weChat:
  app-id: wx153836f1232a5cc1
  dev-mode: true
  token: weixin
  app-secret: 45cdb1251b9e495a7b52928fb60baa69
  wx-article-count: 8
  encrypt-message: false
  encoding-aes-key: FmN1lqkVl1y9PzE0twc60gAwgJa15BtkKJZqgJA8liy
  host: http://36e9930a.ngrok.io
  ws-host: http://captureroom.zzwtec.com
  product-video: http://v-wb.youku.com/v_show/id_XMTU4Mjc2MjMyMA==.html
  zzwtec-open-api-base: http://10.0.0.7:8100
  zzwtec-api-base: http://10.0.0.7:8090
  zzwtec-other-base: http://10.0.0.7:8087
  zzwtec-secret-key: 45cdb1251b9e495a7b52928fb60baa69
  xteaKey: 18c1326ae83347ab
  xteaIv: 9afcd148
  profile: dev
sysUser:
  username: pblimo
  password: 123456
# 短信
sms:
  account: SDK-BBX-010-12586
  password: 527639
  tag: 【智之屋】
  host: http://sdk.entinfo.cn:8060/webservice.asmx
  yzx:
    appid: aa6ad4686bdf4f4fa7c9ad43b6ef5bf8
    sid: e2e16f323fc66eb3d8da446651a96295
    token: c1ec2aeb8d4b43a2c8a533bb052e637b
    templateid: 321808
    url: https://open.ucpaas.com/ol/sms/sendsms

#${weChat.zzwtec-open-api-base}
openapi:
  url:
    login: ${weChat.zzwtec-open-api-base}/admin/login
    login-out: ${weChat.zzwtec-open-api-base}/admin/logout
    query-community-config-by-community-id: ${weChat.zzwtec-open-api-base}/communityConfig/queryCommunityConfigByCommunityId
    query-community-info: ${weChat.zzwtec-open-api-base}/community/queryCommunityInfo
    query-all-build-id-by-community-id: ${weChat.zzwtec-open-api-base}/build/queryAllBuildIdByCommunityId
    query-cell-by-build-id: ${weChat.zzwtec-open-api-base}/cell/queryCellByBuildId
    query-cell-by-cell-id: ${weChat.zzwtec-open-api-base}/cell/queryCellByCellId
    add-cell: ${weChat.zzwtec-open-api-base}/cell/addCell
    update-cell: ${weChat.zzwtec-open-api-base}/cell/updateCell
    delete-cell-by-ids: ${weChat.zzwtec-open-api-base}/cell/deleteCellByIds
    query-user-cell: ${weChat.zzwtec-open-api-base}/userCell/queryUserCell
    delete-user-cell-by-user-id-cell-id: ${weChat.zzwtec-open-api-base}/user/deleteUserCellByUserIdCellId
    add-user-by-user-cell-info: ${weChat.zzwtec-open-api-base}/user/addUserByUserCellInfo
    update-user-by-user-cell-info: ${weChat.zzwtec-open-api-base}/user/updateUserByUserCellInfo
    query-notice-by-community-id: ${weChat.zzwtec-open-api-base}/news/queryNoticeByCommunityId
    query-notice-by-notice-id: ${weChat.zzwtec-open-api-base}/news/queryNoticeByNoticeId
    query-build-by-community-id: ${weChat.zzwtec-open-api-base}/build/queryBuildByCommunityId
    query-build-by-id: ${weChat.zzwtec-open-api-base}/build/queryBuildById
    add-build: ${weChat.zzwtec-open-api-base}/build/addBuild
    delete-build-by-ids: ${weChat.zzwtec-open-api-base}/build/deleteBuildByIds
    update-build: ${weChat.zzwtec-open-api-base}/build/updateBuild
    query-page-door-by-community-id-or-build-id: ${weChat.zzwtec-open-api-base}/door/queryPageDoorByCommunityIdOrBuildId
    query-door-by-id: ${weChat.zzwtec-open-api-base}/door/queryDoorById
    set-door-remote: ${weChat.zzwtec-open-api-base}/door/setDoorRemote