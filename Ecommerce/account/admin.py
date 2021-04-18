from django.contrib import admin
from .models import *


@admin.register(Favorite)
class FavoriteAdmin(admin.ModelAdmin):
    list_display = ['user', 'product', 'is_favorite']
    list_filter = ['user', 'product', 'is_favorite']
