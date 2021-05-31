from django.urls import path
from .views import *

app_name = 'cart'
urlpatterns = [
    path('add/<int:pk>/<int:count>/<int:price>/', AddCart.as_view(), name='add')
]
