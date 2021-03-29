from django.urls import path
from .views import SliderList, CategoryList

app_name = "home"

urlpatterns = [
    path("", SliderList.as_view(), name="home"),
    path("category/", CategoryList.as_view(), name="category"),
]
