from django.urls import path, include
from .views import *

app_name = 'account'
urlpatterns = [
    path('dj-rest-auth/', include('dj_rest_auth.urls')),
    path('dj-rest-auth/registration/', include('dj_rest_auth.registration.urls')),
    path('addfavorite/<int:pk>/', AddFavorite.as_view(), name='addfavorite'),
    path('listfavorite/', ListFavorite.as_view(), name='list_favorite'),
]
