from django.urls import path, include

app_name = 'account'

urlpatterns = [
    path('rest-auth/', include('dj_rest_auth.urls')),
    path('rest-auth/registration/', include('dj_rest_auth.registration.urls')),
]
