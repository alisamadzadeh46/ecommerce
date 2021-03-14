from rest_framework import serializers
from home.models import Slider


class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Slider
        fields = "__all__"
