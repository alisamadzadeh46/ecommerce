from django.urls import path
from .views import *

app_name = "home"

urlpatterns = [
    path("", SliderList.as_view(), name="home"),
    path("category/", CategoryList.as_view(), name="category"),
    path("amazing/", AmazingList.as_view(), name="amazing"),
]
