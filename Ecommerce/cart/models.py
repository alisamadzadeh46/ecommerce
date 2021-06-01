from django.db import models
from django.contrib.auth.models import User

from home.models import Product


class Cart(models.Model):
    user = models.ForeignKey(User, related_name='user', on_delete=models.CASCADE)
    product = models.ForeignKey(Product, related_name='product', on_delete=models.CASCADE)
    is_add = models.BooleanField(default=False)
    count = models.IntegerField(verbose_name='count')
    pay = models.BooleanField(default=False)
    price = models.IntegerField(verbose_name='price')
    total_price = models.IntegerField(verbose_name='total price')

    class Meta:
        verbose_name = 'Cart'
        verbose_name_plural = 'Cart'

    def __str__(self):
        return self.user.username
