
object Data {
    // 使用单例模式，提供全局访问点获取该实例

    // 用来存储MethodList中的任务栈
    var MList: ArrayList<String> = ArrayList()
    // 用来存储每个Activity对应的状态
    var Status: HashMap<String, String> = HashMap()

    // 观察者列表
    private val observers: ArrayList<MyLifecycleObserver> = ArrayList()

    // 注册观察者
    fun registerObserver(observer: MyLifecycleObserver) {
        observers.add(observer)
    }

    // 取消已注册的观察者
    fun unregisterObserver(observer: MyLifecycleObserver) {
        observers.remove(observer)
    }

    // 通知观察者数据发生变化
    private fun notifyObservers() {
        for (observer in observers) {
            observer.onDataChanged()
        }
    }

    // 对现存储的数据进行更新
    fun updateData(name: String, text: String) {
        MList.add("$name.on$text()")
        Status[name] = text
        notifyObservers() // 通知观察者数据发生变化
    }
}
