from django.contrib import admin
from .models import *


@admin.register(Slider)
class ProductAdmin(admin.ModelAdmin):
    list_display = ('name', 'slider_image')
    readonly_fields = ('slider_image',)
