package com.hfad.viewmodelappkotlin.ui.main.model

import com.hfad.viewmodelappkotlin.ui.main.view.Weather

class RepositoryInml:Repository {
    override fun getWeatherfromServer(): Weather {
        return Weather()
    }

    override fun getWeatherfromLocal(): Weather {
        return Weather()
    }
}