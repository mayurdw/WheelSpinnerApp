
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.mayurdw.wheelspinnerapp.viewmodels.WheelSpinnerViewModel


class WheelSpinnerFactory(private val itemList : List<String> ) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WheelSpinnerViewModel( itemList ) as T
    }
}