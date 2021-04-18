from django.db import models
from django.contrib.auth.models import User

from home.models import Product


class Favorite(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    is_favorite = models.BooleanField()

    def __str__(self):
        return self.user
