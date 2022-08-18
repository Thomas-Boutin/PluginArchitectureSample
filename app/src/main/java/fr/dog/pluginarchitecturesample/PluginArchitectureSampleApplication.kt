package fr.dog.pluginarchitecturesample

import android.app.Application
import fr.dog.pluginarchitecturesample.cat.catModule
import fr.dog.pluginarchitecturesample.dog.dogModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PluginArchitectureSampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PluginArchitectureSampleApplication)
            androidLogger()
            modules(catModule, dogModule)
        }
    }
}