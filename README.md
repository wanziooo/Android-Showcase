# Android Showcase

一个面向 Android 初学者与求职展示的 Java 示例项目。

## 第一阶段：基础控件

本示例集中演示：

- TextView 文本
- EditText 输入框
- Button 按钮
- ImageView 图片
- RadioButton 单选
- CheckBox 多选
- Switch 开关
- ProgressBar 进度条
- Spinner 下拉选择
- Toast 消息提示

## 本地运行

1. 用 Android Studio 打开仓库。
2. 等待 Gradle 同步完成。
3. 选择模拟器或 Android 手机。
4. 点击 Run。

## 自动生成 APK

每次推送到 main 分支，GitHub Actions 会自动执行单元测试、编译 Debug APK，并把 APK 保存为构建产物。

进入仓库的 Actions 页面 → 选择最近一次成功构建 → 下载 android-showcase-debug-apk。

## 学习原则

先读 XML 界面，再读 MainActivity.java。每学会一个控件，就修改它的文字、颜色、事件或状态，并提交一次学习记录。
