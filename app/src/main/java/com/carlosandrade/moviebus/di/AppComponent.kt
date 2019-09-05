package com.carlosandrade.moviebus.di

import android.app.Application
import com.carlosandrade.moviebus.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(
        modules = [
            AndroidInjectionModule::class,
            MoviesListModule::class,
            ApiModule::class,
            ActivityBindingModule::class
        ]
)
interface AppComponent : AndroidInjector<App>{

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}