from django.contrib import admin

from cart.models import Cart


@admin.register(Cart)
class CartAdmin(admin.ModelAdmin):
    list_display = ['user', 'product', 'pay', 'is_add']
    list_filter = ['user', 'product', 'pay', 'is_add']
