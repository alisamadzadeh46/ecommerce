from django.urls import path
from .views import *

app_name = 'home'

urlpatterns = [
    path('', SliderList.as_view(), name='home'),
    path('category/', CategoryList.as_view(), name='category'),
    path('categorydetail/<int:pk>/', CategoryDetail.as_view(), name='category_detail'),
    path('product/', ProductList.as_view(), name='amazing'),
    path('product/<int:pk>/', DetailProduct.as_view(), name='product'),
    path('property/<int:pk>/', PropertyProduct.as_view(), name='property'),
    path('rating/<int:pk>/', RatingProduct.as_view(), name='rating'),
    path('price/', PriceProduct.as_view(), name='price'),
    path('comparison/<int:pk>/', ComparisonProduct.as_view(), name='comparison'),
]
