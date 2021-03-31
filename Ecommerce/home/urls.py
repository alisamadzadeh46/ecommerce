from django.urls import path
from .views import *

app_name = 'home'

urlpatterns = [
    path('', SliderList.as_view(), name='home'),
    path('category/', CategoryList.as_view(), name='category'),
    path('product/', ProductList.as_view(), name='amazing'),
    path('product/<int:pk>/', DetailProduct.as_view(), name='product'),
    path('property/<int:pk>/', PropertyProduct.as_view(), name='property'),
]
