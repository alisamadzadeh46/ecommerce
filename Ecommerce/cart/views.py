from rest_framework import status
from rest_framework.permissions import IsAuthenticated
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializer import *


class AddCart(APIView):
    permission_classes = [IsAuthenticated]

    def post(self, request, pk):
        user = request.user
        check = Cart.objects.filter(is_add=True, product_id=pk, user_id=user.id).exists()
        if not check:
            queryset = Cart.objects.create(is_add=True, product_id=pk, count=1, user_id=user.id)
            self.check_object_permissions(request, queryset)
            data = AddCartSerializer(instance=queryset, data=request.data, partial=True)
            if data.is_valid():
                data.save()
                return Response(data.data, status=status.HTTP_201_CREATED)

        return Response({"available": "product is available"})
