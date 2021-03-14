from django.urls import path
from .views import SliderList

app_name = "home"

urlpatterns = [
    path("", SliderList.as_view(), name="home"),

]
