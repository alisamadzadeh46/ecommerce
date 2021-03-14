from rest_framework.generics import ListAPIView
from .serializer import *


class SliderList(ListAPIView):
    queryset = Slider.objects.all()
    serializer_class = ProductSerializer

