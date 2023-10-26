import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver(
    private val name: String,
    private val mList: TextView,
    private val status:TextView,
    ) : LifecycleEventObserver {

    private var datas = Data
    private val tag = "ActivityObserver"
    init {
        // 注册观察者
        datas.registerObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                datas.updateData(name, "Create")
                Log.d(tag, "$name on Create")
            }
            Lifecycle.Event.ON_START -> {
                datas.updateData(name, "Start")
                Log.d(tag, "$name on Start")
            }
            Lifecycle.Event.ON_RESUME -> {
                datas.updateData(name, "Resume")
                Log.d(tag, "$name on Resume")
            }
            Lifecycle.Event.ON_PAUSE -> {
                datas.updateData(name, "Pause")
                Log.d(tag, "$name on Pause")
            }
            Lifecycle.Event.ON_STOP -> {
                datas.updateData(name, "Stop")
                Log.d(tag, "$name on Stop")
            }
            Lifecycle.Event.ON_DESTROY -> {
                datas.updateData(name, "Destroy")
                Log.d(tag, "$name on Destroy")
                // 当实例被销毁之后，删除此观察者
                datas.unregisterObserver(this)
            }
            else -> {
            }
        }
    }

    fun onDataChanged() {
        // 更新Method List
        val stringBuilder = StringBuilder()
        for (item in datas.MList.reversed()) {
            stringBuilder.appendLine(item)
        }
        val outputText = stringBuilder.toString()
        mList.text = outputText

        // 更新Activity Status
        val stringBuilder1 = StringBuilder()
        for ((act, stat) in datas.Status.entries.reversed()) {
            val suffix = when (stat) {
                "Stop" -> "ped"
                "Start", "Destroy" -> "ed"
                else -> "d"
            }
            val text = "$act: $stat$suffix"
            stringBuilder1.appendLine(text)
        }
        val outputText1 = stringBuilder1.toString()
        status.text = outputText1
    }
}
